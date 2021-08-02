
import { CarroService } from "./../carro.service";
import { Component, OnInit } from "@angular/core";
import { Carro } from '../carro';

@Component({
  selector: "app-carro-list",
  templateUrl: "./carro-list.component.html",
  styleUrls: ["./carro-list.component.scss"]
})
export class CarroListComponent implements OnInit {
  public carros: Array<Carro> = [];

  constructor(private carroService: CarroService) {
  }

  ngOnInit() {
    this.findCarros();
  }

  public findCarros() {
    this.carroService.findAll().subscribe(response => this.carros = response);
  }

  public onDelete(id: number) {
    this.carroService.remover(id).subscribe(() => {
      this.findCarros();
    })
  }
}
