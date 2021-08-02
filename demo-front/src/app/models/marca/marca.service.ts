import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { CrudService } from 'src/app/shared/service/crud.service';
import { Marca } from './marca';

@Injectable({
  providedIn: "root"
})
export class MarcaService extends CrudService<Marca> {

  constructor(public httpClient: HttpClient) {
    super(httpClient, 'marcas');
  }
}
