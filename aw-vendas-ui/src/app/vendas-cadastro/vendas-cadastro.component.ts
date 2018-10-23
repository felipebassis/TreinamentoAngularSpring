import { Component, OnInit } from '@angular/core';
import { VendasService } from '../vendas/vendas.service';
import { FormGroup } from '../../../node_modules/@angular/forms';

@Component({
  selector: 'app-vendas-cadastro',
  templateUrl: './vendas-cadastro.component.html',
  styleUrls: ['./vendas-cadastro.component.css']
})
export class VendasCadastroComponent implements OnInit {

  venda: any = { itemDTOList: [], frete: 0.0, total: 0.0 };
  item: any = {};
  clientes: Array<any>;
  produtos: Array<any>;

  constructor(private vendasService: VendasService) { }

  ngOnInit() {
    this.vendasService.listarClientes()
      .subscribe(response => this.clientes = response);

    this.vendasService.listarProdutos()
      .subscribe(response => this.produtos = response);

    this.novaVenda();
  }

  incluirItem() {
    this.item.total = this.item.produtoDTO.valor * this.item.quantidade;

    this.venda.itemDTOList.push(this.item);

    this.item = {};

    this.calcularTotal();
  }

  novaVenda() {
    this.venda = { itemDTOList: [], frete: 0.0, total: 0.0 };
    this.item = {};
  }

  calcularTotal() {
    const totalItens = this.venda.itemDTOList
      .map(i => (i.produto.valor * i.quantidade))
      .reduce((total, v) => total + v, 0);

    this.venda.total = totalItens + this.venda.frete;
  }

  adicionar(frm: FormGroup) {
    this.vendasService.adicionar(this.venda).subscribe(Response => {
      frm.reset();

      this.novaVenda();
      
      });
  }

}
