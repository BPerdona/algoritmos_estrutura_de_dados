#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define MAX 10

//Struct para as informações do Livro
typedef struct _livros{
    int idLivro;
    int paginasLivro;
    char nomeLivro[20];
    char generolivro[20];
}Livros;

//Struct para a lista
typedef struct _listaLinear{
    Livros **livros;
    int nLivros;
    int maxLivros;
}ListaLinear;

//Struct para as informações do Autor
typedef struct _autor{
    char nome[20];
    int idade;
    ListaLinear *lista;
}Autor;

ListaLinear* iniciarLista(int quantidade){

    //Criando e Iniciando lista
    ListaLinear *lista = (ListaLinear* ) malloc(sizeof(ListaLinear));
    lista->nLivros = 0;
    lista->maxLivros = quantidade;

    //Inicializando o vetor de endereços
    lista->livros = (Livros** ) malloc(sizeof(Livros*)*quantidade);
    return lista;
}

Autor* novoAutor(ListaLinear lista, int quantidade){
    Autor *escritor = (Autor*) malloc(sizeof(Autor)*quantidade);

}

void imprimirLista(ListaLinear *lista){

    //Imprimir Lista
    printf("\n __________Lista__________\n");
    for(int i=0; i < lista->nLivros; i++){
        printf("Posicao: %d - Id: %d - Paginas: %d - Nome: %s - Genero: %s \n", i, lista->livros[i]->idLivro, lista->livros[i]->paginasLivro, lista->livros[i]->nomeLivro, lista->livros[i]->generolivro);
    }
}

void verMenu(){

    //Print do Menu

    printf("\n\n ____Bem-vindo ao menu____");
    printf("\n\nEscolha uma opcao: \n");
    printf("(1) Mostrar Dados do Autor \n"); //Feito
    printf("(2) Inserir Livro \n"); //Feito
    printf("(3) Obter Numero de Livros\n"); //feito
    printf("(4) Imprimir Lista de Livros\n"); //Feito
    printf("(5) Obter Livro por Indice\n"); //Feito
    printf("(6) Obter Livro por ID \n"); //Feito
    printf("(7) Obter Indice por ID \n"); //Feito
    printf("(8) Remover Livro por Indice \n"); //Feito
    printf("(9) Remover Livro por ID \n"); //Feito
    printf("(10) Sair \n"); //Feito
    printf("Sua opcao: ");
}

bool inserirLivro(ListaLinear *lista){
    
    //Criando uma variavel temporaria do tipo Livros
    Livros *l = (Livros*) malloc(sizeof(Livros));
    int indice=0;

    //Pedindo dados para o usuario
    printf("Insira o indice na lista: \n");
    scanf("%i", &indice);

    //Conferindo requisitos
    if(indice > lista->nLivros || indice < 0 || lista->nLivros == lista->maxLivros){
        printf("\n\n\nNão foi possivel adicionar!!");
        return false;    
    }

    printf("Insira o Id do livro \n");
    scanf("%i", &l->idLivro);

    printf("Insira o nome do livro \n");
    scanf("%s", &l->nomeLivro);

    printf("Insira o numero de paginas do livro \n");
    scanf("%i", &l->paginasLivro);
   
    printf("Insira o genero do livro \n");
    scanf("%s", &l->generolivro);

    //Percorrendo a lista
    int i;
    for(i=lista->nLivros; i>=0; i--){
        if(i==indice){
            break;
        }
        lista->livros[i] = lista->livros[i-1];
    }
    //Inserindo dados e acrescentando 1 ao Numero de Livros
    lista->livros[i] = l;
    lista->nLivros++;
}

int obterNumeroLivros(ListaLinear *lista){
    return lista->nLivros;
}

Livros* obterLivroPorIndice(ListaLinear *lista, int indice){
    //Verificação para ver se é possivel encontrar o indice
    if(indice >= lista->nLivros || indice < 0){
        printf("\n\n Indice nao valido!!!");
        return NULL;
    }
    return lista->livros[indice];
}

int obterLivroPorId(ListaLinear *lista, int id){
    //Percorre a lista em idLivro para comparar os ids
    for(int i=0; i < lista->nLivros; i++){
        if(lista->livros[i]->idLivro == id){
            return i;
        }
    }
    return -1;
}

void removerLivroPorIndice(ListaLinear *lista, int indice){
    //Validação dos requisitos possiveis para a remoção de um livro
    if(indice < 0 || indice >= lista->nLivros){
        printf("\nFalha na exclusão do livro.\n");
    }else{
        int i;
        for(i=indice; i < lista->nLivros - 1; i++){
            lista->livros[i] = lista->livros[i+1];
        }
        lista->livros[i] = NULL;
        lista->nLivros--;
        printf("\nExclusao do indice %i feita com sucesso.\n", indice);
    }
}

void removerLivroPorId(ListaLinear *lista, int id){
    //Validação dos requisitos possiveis para a remoção de um livro
    int i, saida=0;
    for(i=0; i<lista->nLivros; i++){
        if(lista->livros[i]->idLivro == id){
            removerLivroPorIndice(lista,i);
            saida=1;
        }
    }
    //Caso o id nao seja encontrado
    if(saida != 1){
        printf("\nNao foi possivel encontrar esse ID.\n");
    }
}

int main(){
    int op=0, aux, indice;

    //Criando lista
    ListaLinear *lista = iniciarLista(MAX);
   
    //Criando Autor
    Autor *escritor = (Autor*) malloc(sizeof(Autor));

    //Adicionando valores aos atributos de Autor
    printf("\n____Criando um novo Autor____\n");
    printf("\nInsira o nome do Autor: ");
    scanf("%s", &escritor->nome);
    printf("Insira a idade do Autor: ");
    scanf("%i", &escritor->idade);

    //A lista de escritor recebe a lista previamente criada
    escritor->lista = lista;

    while(op!=10){
        verMenu();
        scanf("%i", &op);
        switch(op){
            case 1:{
                printf("\n____Autor____\n");
                printf("\n Nome do autor: %s", escritor->nome);
                printf("\n Idade: %i", escritor->idade);
                printf("\n Endereco da Lista: %p\n\n", escritor->lista);
                break;
            }
            case 2:{
                inserirLivro(lista);
                break;
            }
            case 3:{
                printf("\nNumero de livros: %i", obterNumeroLivros(lista));
                break;
            }
            case 4:{
                imprimirLista(lista);
                break;
            }
            case 5:{
                printf("Insira o indice que deseja ver: ");
                scanf("%i", &aux);
                Livros *temp = obterLivroPorIndice(lista, aux);
                if(temp!=NULL){
                    printf("\n __________Resultado__________\n\n");
                    printf("Posicao: %d - Id: %d - Paginas: %d - Nome: %s - Genero: %s \n",aux ,temp->idLivro, temp->paginasLivro, temp->nomeLivro, temp->generolivro);
                }
                break;
            }
            case 6:{
                printf("Insira o Id do livro: ");
                scanf("%i", &aux);
                indice = obterLivroPorId(lista, aux);
                if(indice!=-1){
                    printf("\n __________Resultado__________\n\n");
                    printf("Posicao: %d - Id: %d - Paginas: %d - Nome: %s - Genero: %s \n",indice ,lista->livros[indice]->idLivro, lista->livros[indice]->paginasLivro, lista->livros[indice]->nomeLivro, lista->livros[indice]->generolivro);
                }
                break;
            }
            case 7:{
                //Mesmo codigo do case 5, apenas mudando a saida.
                printf("Insira o ID que deseja descobrir o indice: ");
                scanf("%i", &aux);
                indice = obterLivroPorId(lista, aux);
                if(indice!=-1){
                    printf("\n __________Resultado__________\n\n");
                    printf("\n Indice: %i",indice);
                }
                break;
            }
            case 8:{
                printf("Insira o Indice que deseja excluir: ");
                scanf("%i", &indice);
                removerLivroPorIndice(lista, indice);
                break;
            }
            case 9:{
                printf("Insira o Id que deseja excluir: ");
                scanf("%i", &aux);
                removerLivroPorId(lista, aux);
                break;
            }
            case 10:{
                break;
            }
            default :{
                printf("\n\n\n\n\n Valor invalido!! \n\n\n\n\n");
            }
        }
    }
    return 0;
}
