
import { Component, OnInit } from "@angular/core";
import { Marca } from "../marca";
import { MarcaService } from "../marca.service";

@Component({
  selector: "app-marca-list",
  templateUrl: "./marca-list.component.html",
  styleUrls: ["./marca-list.component.scss"]
})
export class MarcaListComponent implements OnInit {
  public marcas: Array<Marca> = [];

  constructor(private marcaService: MarcaService) {
  }

  ngOnInit() {
    this.findMarcas();
  }

  public findMarcas() {
    this.marcaService.findAll().subscribe(response => this.marcas = response);
  }

  public onDelete(id: number) {
    this.marcaService.remover(id).subscribe(() => {
      this.findMarcas();
    })
  }
}
