import { Component, OnInit } from '@angular/core';
import { VendasService } from '../vendas/vendas.service';

@Component({
  selector: 'app-vendas-cadastro',
  templateUrl: './vendas-cadastro.component.html',
  styleUrls: ['./vendas-cadastro.component.css']
})
export class VendasCadastroComponent implements OnInit {

  venda = { itens: []};
  item: any = {};
  clientes: Array<any>;
  produtos: Array<any>;

  constructor(private vendasService: VendasService) { }

  ngOnInit() {
    this.vendasService.listarClientes()
      .subscribe(response => this.clientes = response);

    this.vendasService.listarProdutos()
      .subscribe(response => this.produtos = response);
  }

  incluirItem() {
    this.item.total = this.item.produto.valor * this.item.quantidade;

    this.venda.itens.push(this.item);

    this.item = {};
  }

}
