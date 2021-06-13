import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Livro> livros = new ArrayList<Livro>();
    static ArrayList<Autor> autores = new ArrayList<Autor>();


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\r?\n");
        boolean loop = true;

        while(loop){
            System.out.println("(1) Adicionar novo autor");
            System.out.println("(2) Adicionar novo livro");
            System.out.println("(3) Adicionar um livro a um autor");
            System.out.println("(4) Editar autor");
            System.out.println("(5) Editar livro");
            System.out.println("(6) Listar todos os autores");
            System.out.println("(7) Listar todos os livros");
            System.out.println("(8) Listar todos os livros de um autor");
            System.out.println("(9) Buscar um autor");
            System.out.println("(10) Buscar um livro");
            System.out.println("(0) Fechar programa");

            int userOption = sc.nextInt();
            switch(userOption){
                case 1:
                    //add novo Autor
                    System.out.println("Insira o nome do autor: ");
                    String nome = sc.next();


                    System.out.println("Insira a idade do autor: ");
                    int idade = sc.nextInt();

                    System.out.println("Insira o Id do autor: ");
                    int autorId = sc.nextInt();

                    //verificação id
                    boolean verif = true;
                    if(verificarIdAutor(autorId)){
                        System.out.println("\nId de autor já existente!!\n");
                        verif = false;
                    }

                    if(!verif){
                        break;
                    }else {
                        Autor autorTemp = new Autor(nome, idade, autorId);
                        autores.add(autorTemp);
                        System.out.println("\nAutor adicionado com sucesso!!\n");
                    }

                    break;

                case 2:
                    //add novo livro
                    System.out.println("Insira o titulo do livro: ");
                    String titulo = sc.next();

                    System.out.println("Insira a Categoria do livro: ");
                    String categoria = sc.next();

                    sc.reset();

                    System.out.println("Possui capa dura? (1=Sim | 2=Nao)");
                    int result = sc.nextInt();

                    boolean capaDura;
                    if(result == 1){
                        capaDura = true;
                    }else if(result == 2){
                        capaDura = false;
                    }else{
                        System.out.println("Resposta invalida!");
                        break;
                    }

                    System.out.println("Insira o Numero de Paginas: ");
                    int nPaginas = sc.nextInt();

                    System.out.println("Insira o codigo do livro: ");
                    int codigoLivro = sc.nextInt();


                    Livro livroTemp = new Livro(titulo, nPaginas, categoria, capaDura, codigoLivro);
                    livros.add(livroTemp);

                    System.out.println("\nLivro adicionado com sucesso!!\n");

                    break;

                case 3:
                    //livro no autor
                    if(autores.size()!=0 || livros.size()!=0) {
                        listarAutores();
                        System.out.println("Selecione um autor: ");
                        int autorOption = sc.nextInt();

                        listarLivros();
                        System.out.println("Selecione o livro que deseja adicionar ao autor");
                        int livroOption = sc.nextInt();

                        boolean verifIdAutor = false;

                        for (int i = 0; i < autores.size(); i++) {
                            if (autorOption == autores.get(i).getAutorId()) {
                                verifIdAutor = true;

                                //Adicionando livro em autor
                                Livro lTemp = livros.get(livroOption);
                                Autor autor = autores.get(i);
                                autor.addLivro(lTemp);
                            }
                        }

                        if (verifIdAutor) {
                            System.out.println("\nLivro adicionado a autor com sucesso!!\n");
                        } else {
                            System.out.println("\nId de Autor não encontrado!!\n");
                        }
                    }else{
                        System.out.println("\nLista de Autores ou Livros vazia!!\n");
                    }
                    break;

                case 4:
                    //aditar Autor
                    if(autores.size()!=0) {
                        listarAutores();
                        System.out.println("\nSelecione um autor que deseja alterar: ");
                        int idSetAutor = sc.nextInt();

                        boolean idAutorEncontrado = false;
                        for(int i=0; i<autores.size(); i++){
                            if(idSetAutor == autores.get(i).getAutorId()){

                                Autor autorAtual = autores.get(i);
                                idAutorEncontrado = true;

                                System.out.println("\nMudar nome do autor '"+autorAtual.getNome()+"' para: ");
                                String nomeAtual = sc.next();
                                autorAtual.setNome(nomeAtual);

                                System.out.println("\nMudar a idade do autor '"+autorAtual.getNome()+"' de '"+autorAtual.getIdade()+"' para: ");
                                int idadeAtual = sc.nextInt();
                                autorAtual.setIdade(idadeAtual);

                                System.out.println("\nMudar o ID do autor '"+autorAtual.getNome()+"' de '"+autorAtual.getAutorId()+"' para: ");
                                int idAutorAtual = sc.nextInt();
                                autorAtual.setAutorId(idAutorAtual);

                                System.out.println("\n Todos os valores foram alterados!! \n");
                            }
                        }

                        if(!idAutorEncontrado){
                            System.out.println("\nId de autor não encontrado!!\n");
                        }

                    }else{
                        System.out.println("Lista de Autores vazia");
                    }
                    break;

                case 5:
                    //editar livro
                    if(livros.size()!=0) {
                        listarLivros();
                        System.out.println("Selecione um livro: ");
                        int indexSetLivro = sc.nextInt();

                        if(indexSetLivro > livros.size() || indexSetLivro < 0) {
                            System.out.println("Id invalido");

                        }else{
                            Livro livroAtual = livros.get(indexSetLivro);
                            int idLivroInicial = livroAtual.getCodigoLivro();

                            System.out.println("\nMudar o titulo do livro '"+livroAtual.getTitulo()+"' para: ");
                            String tituloAtual = sc.next();
                            livroAtual.setTitulo(tituloAtual);

                            System.out.println("\nMudar o numero de paginas do livro '"+livroAtual.getTitulo()+"' de '"+livroAtual.getnPaginas()+"' para: ");
                            int paginaAtual = sc.nextInt();
                            livroAtual.setnPaginas(paginaAtual);

                            System.out.println("\nMudar a categoria do livro '"+livroAtual.getTitulo()+"' de '"+livroAtual.getCategoria()+"' para: ");
                            String categoriaAtual = sc.next();
                            livroAtual.setCategoria(categoriaAtual);

                            String capa;
                            if(livroAtual.isCapaDura()){
                                capa = "Capa Dura";
                            }else{
                                capa = "Capa Mole";
                            }
                            System.out.println("\nMudar a capa do livro '"+livroAtual.getTitulo()+"' de '"+capa+"' para: (1-Capa Dura/ 2-Capa Mole)");
                            int capaAtual = sc.nextInt();

                            if(capaAtual==1){
                                livroAtual.setCapaDura(true);
                            }else if(capaAtual==2){
                                livroAtual.setCapaDura(false);
                            }else{
                                System.out.println("\nOpção invalida, capa não alterada\n");
                            }

                            System.out.println("\nMudar o codigo do livro '"+livroAtual.getTitulo()+"' de '"+livroAtual.getCodigoLivro()+"' para:");
                            int codigoAtual = sc.nextInt();
                            livroAtual.setCodigoLivro(codigoAtual);


                            for(int i=0; i<autores.size(); i++){
                                for(int j=0; j<autores.get(i).sizeLivros(); j++){
                                    if(autores.get(i).getLivro(j).getCodigoLivro() == idLivroInicial){
                                        Autor autor = autores.get(i);
                                        autor.setLivro(livroAtual, j);
                                    }
                                }
                            }


                            System.out.println("\n Todos os valores foram alterados!! \n");
                        }


                    }else{
                        System.out.println("\nLista de livros vazia!\n");
                    }
                    break;

                case 6:
                    //listar todos os Autores
                    listarAutores();
                    break;

                case 7:
                    //listar todos os Livros
                    listarLivros();
                    break;

                case 8:
                    //listar todos os livros de um Autor (passar nome ou id do autor)
                    listarAutores();
                    System.out.println("\nInsira o ID de autor que deseja:");
                    int autorIdSelect = sc.nextInt();

                    if(verificarIdAutor(autorIdSelect)){
                        autorIdSelect = encontrarIndex(autorIdSelect);

                        Autor listAutor = autores.get(autorIdSelect);
                        listAutor.listLivros();

                    }else{
                        System.out.println("\nId de autor invalido!!\n");
                    }

                    break;

                case 9:
                    //buscar um Autor por id ou nome e todas as suas informações
                    listarAutores();
                    System.out.println("\nSelecione um autor: ");
                    int infoAutor = sc.nextInt();

                    if(verificarIdAutor(infoAutor)){
                        int index = encontrarIndex(infoAutor);
                        System.out.println("\n_____Detalhes do autor_____\n");
                        System.out.println("\nNome do autor: "+autores.get(index).getNome());
                        System.out.println("Idade: "+autores.get(index).getIdade());
                        System.out.println("Id Autor: "+autores.get(index).getAutorId());
                    }else{
                        System.out.println("\nId de autor não encontrado!!\n");
                    }

                    break;

                case 10:
                    //buscar um livro por id ou nome e mostrar todas as suas informações
                    listarLivros();
                    System.out.println("\nSelecione um livro");
                     int infoLivro = sc.nextInt();

                     if(infoLivro >= 0 || infoLivro<=livros.size()){
                         System.out.println("\n_____Detalhes do livro_____\n");
                         System.out.println("\nTitulo: "+livros.get(infoLivro).getTitulo());
                         System.out.println("Categoria: "+livros.get(infoLivro).getCategoria());
                         System.out.println("Nº Paginas: "+livros.get(infoLivro).getnPaginas());
                         int capaAux;
                         if(livros.get(infoLivro).isCapaDura()){
                             capaAux = 1;
                         }else{
                             capaAux = 2;
                         }
                         System.out.println("Capa(1=Dura/2=Mole): "+capaAux);
                         System.out.println("Codigo do Livro:"+livros.get(infoLivro).getCodigoLivro()+"\n\n");
                     }
                    break;

                case 0:
                    loop = false;
                    break;

                default:
                    System.out.println("Digite uma opção valida");
                    break;
            }
        }
    }

    static void listarAutores(){
        System.out.println("\n\n");
        System.out.println("_____AUTORES_____");
        for(int indexAutor = 0; indexAutor < autores.size(); indexAutor++){
            System.out.println("Autor["+autores.get(indexAutor).getAutorId()+"] Nome: "+autores.get(indexAutor).getNome());
        }
        System.out.println("\n\n");
    }

    static void listarLivros(){
        System.out.println("\n\n");
        System.out.println("_____LIVROS_____");
        for(int indexLivro = 0; indexLivro<livros.size(); indexLivro++){
            System.out.println("Livro["+indexLivro+"] Titulo: "+livros.get(indexLivro).getTitulo());
        }
        System.out.println("\n\n");
    }

    static boolean verificarIdAutor(int id){
        for(int i = 0; i < autores.size(); i++){
            if(id == autores.get(i).getAutorId()){
                return true;
            }
        }
        return false;
    }

    static int encontrarIndex(int id){
        for(int i = 0; i < autores.size(); i++){
            if(id == autores.get(i).getAutorId()){
                return i;
            }
        }
        return -1;
    }
}
