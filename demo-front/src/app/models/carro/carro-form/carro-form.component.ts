import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { Carro } from "../carro";
import { CarroService } from "../carro.service";

@Component({
  selector: "app-carro-form",
  templateUrl: "./carro-form.component.html",
  styleUrls: ["./carro-form.component.scss"]
})
export class CarroFormComponent implements OnInit {

  public carro: Carro;

  public carroForm: FormGroup;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private carroService: CarroService
  ) { }

  ngOnInit(): void {
    this.initForm();
    this.carro = new Carro();
  }

  private initForm(): void {
    this.carroForm = this.formBuilder.group({
      id: null,
      nome: [null, [Validators.required]],
      kmPorGalao: [null, [Validators.required]],
      cilindros: [null, [Validators.required]],
      cavaloDeForca: [null, [Validators.required]],
      peso: [null, [Validators.required]],
      aceleracao: [null, [Validators.required]],
      ano: [null, [Validators.required]],
      origem: [null, [Validators.required]]
    });
  }

  public onSave(): void {
    if (this.carroForm.valid) {
      this.carroService.salvar(this.carroForm.value).subscribe(() => {
        this.router.navigate(['/carro']);
      });
    }
  }
}
