import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { Marca } from "../marca";
import { MarcaService } from "../marca.service";

@Component({
  selector: "app-marca-form",
  templateUrl: "./marca-form.component.html",
  styleUrls: ["./marca-form.component.scss"]
})
export class MarcaFormComponent implements OnInit {

  public marca: Marca;

  public marcaForm: FormGroup;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private marcaService: MarcaService
  ) { }

  ngOnInit(): void {
    this.initForm();
    this.marca = new Marca();
  }

  private initForm(): void {
    this.marcaForm = this.formBuilder.group({
      id: null,
      nome: [null, [Validators.required]],
      origem: [null, [Validators.required]]
    });
  }

  public onSave(): void {
    if (this.marcaForm.valid) {
      this.marcaService.salvar(this.marcaForm.value).subscribe(() => {
        this.router.navigate(['/marca']);
      });
    }
  }
}
