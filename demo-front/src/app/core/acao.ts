import { ActivatedRoute } from "@angular/router";

export enum Acao {
  VISUALIZAR = "visualizar",
  INSERIR = "inserir",
  ALTERAR = "alterar"
}

export class AcaoSistema {

  private acao: Acao;

  constructor(route?: ActivatedRoute) {
    if (route !== null && route !== undefined) {
      const data = route.snapshot.data;

      for (const index of Object.keys(data)) {
        const param = data[index];

        if (
          param !== null &&
          typeof param === "object" &&
          param["acao"] !== undefined
        ) {
          this.acao = param["acao"];
          break;
        }
      }
    }
  }

  public setAcao(acao: Acao): AcaoSistema {
    this.acao = acao;
    return this;
  }
  x
  public isAcaoInserir(): boolean {
    return Acao.INSERIR === this.acao;
  }

  public isAcaoAlterar(): boolean {
    return Acao.ALTERAR === this.acao;
  }

  public isAcaoVisualizar(): boolean {
    return Acao.VISUALIZAR === this.acao;
  }
}
