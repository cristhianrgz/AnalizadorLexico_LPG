package codigo;
import static codigo.token.*;

/* SECCION DE DECLARACIONES DE JFLEX */ 
%%
%class lexer
%type token
%line
%char
%column
L=[a-zA-Z_]+
Lm=[a-z]+
D=[0-9]+
espacio=[ ,\t,\r]+
%{
public String lexeme;
guardarInfoCod c = new guardarInfoCod();
%}

/* EXPRESIONES REGULARES VALIDAS PARA CADENAS */

%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}


/* Salto de linea */

<YYINITIAL> "\n"  {c.linea=yyline;lexeme=yytext();return saltoLinea; }

/* Comillas */

<YYINITIAL> "\"" {c.linea=yyline;lexeme=yytext();return comillas; }

/* OPERADORES NUMÉRICOS */
<YYINITIAL> "++"  {c.linea=yyline;lexeme=yytext();return op_incremento; }

<YYINITIAL> "--" {c.linea=yyline;lexeme=yytext(); return op_decremento; }

<YYINITIAL> "+" {c.linea=yyline;lexeme=yytext(); return op_aritmetico; }

<YYINITIAL> "-" {c.linea=yyline;lexeme=yytext(); return op_aritmetico; }

<YYINITIAL> "*" {c.linea=yyline;lexeme=yytext(); return op_aritmetico; }

<YYINITIAL> "/" {c.linea=yyline;lexeme=yytext(); return op_aritmetico; }

<YYINITIAL> "%" {c.linea=yyline;lexeme=yytext(); return op_aritmetico; }

<YYINITIAL> "**" {c.linea=yyline;lexeme=yytext(); return op_aritmetico; }

/* OPERADORES NUMÉRICOS */
<YYINITIAL> "||"  {c.linea=yyline; lexeme=yytext(); return op_logico; }

<YYINITIAL> "&&"  {c.linea=yyline; lexeme=yytext(); return op_logico; }

<YYINITIAL> "!"  {c.linea=yyline; lexeme=yytext(); return op_logico; }

/* OPERADORES RELACIONALES */
<YYINITIAL> ">" {c.linea=yyline;lexeme=yytext(); return op_relacional; }

<YYINITIAL> "<" {c.linea=yyline;lexeme=yytext(); return op_relacional; }

<YYINITIAL> ">=" {c.linea=yyline;lexeme=yytext(); return op_relacional; }

<YYINITIAL> "<=" {c.linea=yyline;lexeme=yytext(); return op_relacional; }

<YYINITIAL> "!=" {c.linea=yyline;lexeme=yytext(); return op_relacional; }

<YYINITIAL> "==" {c.linea=yyline;lexeme=yytext(); return op_relacional; }

<YYINITIAL> "=" {c.linea=yyline;lexeme=yytext(); return op_asignacion; }

/* OTROS SIMBOLOS*/
<YYINITIAL> "(" {c.linea=yyline;lexeme=yytext(); return parentesis_a; }

<YYINITIAL> ")" {c.linea=yyline;lexeme=yytext(); return parentesis_c; }

<YYINITIAL> "[" {c.linea=yyline;lexeme=yytext(); return corchete_a; }

<YYINITIAL> "]" {c.linea=yyline;lexeme=yytext(); return corchete_c; }

<YYINITIAL> "{" {c.linea=yyline;lexeme=yytext(); return llave_a; }

<YYINITIAL> "}" {c.linea=yyline;lexeme=yytext(); return llave_c; }

<YYINITIAL> ":=" {c.linea=yyline;lexeme=yytext(); return otros; }

<YYINITIAL> ";" {c.linea=yyline;lexeme=yytext(); return p_coma; }

<YYINITIAL> "," {c.linea=yyline;lexeme=yytext(); return simbol_p; }

<YYINITIAL> ":" {c.linea=yyline;lexeme=yytext(); return dos_puntos; }

/* Numero */
<YYINITIAL> ("(-"{D}+")")|{D}+|[0-9]+[.][0-9]+ {c.linea=yyline;lexeme=yytext(); return numero; }

<YYINITIAL> inicio {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "programa" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "fin" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "montar" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LLDG" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "mostrar" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "dibujar" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "si" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "sino" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "hacer" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "mientras" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "modelo" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "imprimir" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "obtener" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "orden_principal" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LLDGconoSol" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LLDGconoLin" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LLDGcuboSol" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LLDGcuboLin" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LLDGesferaSol" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LLDGesferaLin" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LLDGrectanSol" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LLDGrectanLin" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGrotar" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGlimpiarBuffer" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGlimpiarBufferColor" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "color_Buffer_Bit" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "profundidad_Buffer_Bit" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "acumulacion_Buffer_Bit" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "plantilla_Buffer_Bit" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGModoPoligono" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGMaterial" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGColor" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGVertice" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGEmpezar" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGTerminar" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Puntos" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Lineas" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Linea_Lin" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Linea_Ciclo" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Triangulos" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Triangulo_Lin" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Triangulo_Abanico" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Cuadrado" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Cuadrado_Lin" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Poligono" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGModoMatriz" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Vista_Modelo" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Proyeccion" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Textura" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Color" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGMatrizOrtografica" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGMatrizPerspectiva" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGMatrizIdentidad" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGVer" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGVolverAMostrar" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGModoVisualizacion" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGPosicionVentanaInicio" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGTamañoVentanaInicio" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGCrearVentana" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGMostrarFuncion" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGRemodeladoFuncion" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGLazoPrincipal" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGMatrizOrtografica2D" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGVentana" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LGEjecucionLineas" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_RGBA" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_RGB" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Indice" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Solo" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Doble" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Acumulacion" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Alfa" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Profundo" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Plantilla" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_MuestreoMultiple" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Estereo" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "LG_Luminosa" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "cad" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "bool" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "ent" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "numDec" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "numDecL" {c.linea=yyline;lexeme=yytext(); return p_reservada; }
<YYINITIAL> "elemento" {c.linea=yyline;lexeme=yytext(); return p_reservada; }

<YYINITIAL> {Lm}({L}|{D})* {c.linea=yyline;lexeme=yytext(); return identificador; }


/* ERRORES PARA EL LENGUAJE */
. {c.linea=yyline;lexeme=yytext(); return ERROR; }


