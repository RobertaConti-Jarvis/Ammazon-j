import { ProdottoColore } from "./prodotto-colore";
import { VarianteTaglia } from "./variante-taglia";

export class ColoreTaglia{
    id: number;
    varianteTaglia: VarianteTaglia;
    prodottoColore: ProdottoColore;
    giacenza: number;
}