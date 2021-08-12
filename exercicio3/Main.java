import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    private static final int tamanho = 50000;
    private static final Integer[] vetorNumeros = new Integer[tamanho];
    private static final ArrayList<Integer> arrayList = new ArrayList<>();
    private static final LinkedList<Integer> linkedList = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        long start;
        long end;

        initLists();

        //Iniciando objetos para serem usados para salvar resultados e um arquivo
        FileWriter arq = new FileWriter("C:\\Users\\bruno\\Desktop\\resultado.txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        //Inserindo numeros aleatorios nas estrutura de dados
        insertRandomNumbers();

        //TODO VETORES

        gravarArq.println("\n__________VETORES__________");
        System.out.println("\n__________VETORES__________");


        //Bubble Sort em Vetor
        start = System.currentTimeMillis();
        bubbleSort(vetorNumeros, tamanho);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do bubbleSort em vetor: "+end+" ms");
        gravarArq.println("Tempo do bubbleSort em vetor: "+end+" ms");
        insertRandomNumbers();



        //selection Sort em Vetor
        start = System.currentTimeMillis();
        selectionSort(vetorNumeros, tamanho);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Selection Sort em vetor: "+end+" ms");
        gravarArq.println("Tempo do Selection Sort em vetor: "+end+" ms");
        insertRandomNumbers();


        //Insertion Sort em Vetor
        start = System.currentTimeMillis();
        insertionSort(vetorNumeros, tamanho);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Insertion Sort em vetor: "+end+" ms");
        gravarArq.println("Tempo do Insertion Sort em vetor: "+end+" ms");
        insertRandomNumbers();


        //Merge Sort em Vetor
        start = System.currentTimeMillis();
        mergeSort(vetorNumeros,0,tamanho-1);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Merge Sort em vetor: "+end+" ms");
        gravarArq.println("Tempo do Merge Sort em vetor: "+end+" ms");
        insertRandomNumbers();

        //Quick Sort
        start = System.currentTimeMillis();
        quickSort(vetorNumeros,0,tamanho-1);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Quick Sort em vetor: "+end+" ms");
        gravarArq.println("Tempo do Quick Sort em vetor: "+end+" ms");
        insertRandomNumbers();

        //Java.sort em vetores
        start = System.currentTimeMillis();
        Arrays.sort(vetorNumeros);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Java.sort em vetor: "+end+" ms");
        gravarArq.println("Tempo do Java.sort em vetor: "+end+" ms");
        insertRandomNumbers();


        //TODO LINKED LIST

        gravarArq.println("\n__________Linked_List__________");
        System.out.println("\n__________Linked_List__________");

        //Bubble Sort em LinkedList
        start = System.currentTimeMillis();
        bubbleSortLinkedList(linkedList, tamanho);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do bubbleSort em Linked List: "+end+" ms");
        gravarArq.println("Tempo do bubbleSort em Linked List: "+end+" ms");
        insertRandomNumbers();

        //selection Sort em LinkedList
        start = System.currentTimeMillis();
        selectionSortLinkedList(linkedList, tamanho);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Selection Sort em Linked List: "+end+" ms");
        gravarArq.println("Tempo do Selection Sort em Linked List: "+end+" ms");
        insertRandomNumbers();

        //Insertion Sort em LinkedList
        start = System.currentTimeMillis();
        insertionSortLinkedList(linkedList, tamanho);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Insertion Sort em Linked List: "+end+" ms");
        gravarArq.println("Tempo do Insertion Sort em Linked List: "+end+" ms");
        insertRandomNumbers();


        //MergeSort em LinkedList
        start = System.currentTimeMillis();
        mergeSortLinkedList(linkedList,0,tamanho-1);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Merge Sort em Linked List: "+end+" ms");
        gravarArq.println("Tempo do Merge Sort em Linked List: "+end+" ms");
        insertRandomNumbers();


        //Quick Sort em LinkedList
        start = System.currentTimeMillis();
        quickSortLinkedList(linkedList,0,tamanho-1);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Quick Sort em Linked List: "+end+" ms");
        gravarArq.println("Tempo do Quick Sort em Linked List: "+end+" ms");
        insertRandomNumbers();

        //Collection.sort em linkedList
        start = System.currentTimeMillis();
        Collections.sort(linkedList);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Java.sort em Linked List: "+end+" ms");
        gravarArq.println("Tempo do Collection.sort em Linked List: "+end+" ms");
        insertRandomNumbers();


        //TODO ARRAYLIST

        gravarArq.println("\n__________Array_List__________");
        System.out.println("\n__________Array_List__________");

        //Bubble Sort em ArrayList
        start = System.currentTimeMillis();
        bubbleSortArrayList(arrayList, tamanho);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do bubbleSort em Array List: "+end+" ms");
        gravarArq.println("Tempo do bubbleSort em Array List: "+end+" ms");
        insertRandomNumbers();


        //selection Sort em ArrayList
        start = System.currentTimeMillis();
        selectionSortArrayList(arrayList, tamanho);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Selection Sort em Array List: "+end+" ms");
        gravarArq.println("Tempo do Selection Sort em Array List: "+end+" ms");
        insertRandomNumbers();

        //Insertion Sort em ArrayList
        start = System.currentTimeMillis();
        insertionSortArrayList(arrayList, tamanho);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Insertion Sort em Array List: "+end+" ms");
        gravarArq.println("Tempo do Insertion Sort em Array List: "+end+" ms");
        insertRandomNumbers();

        //MergeSort em ArrayList
        start = System.currentTimeMillis();
        mergeSortArrayList(arrayList,0,tamanho-1);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Merge Sort em Array List: "+end+" ms");
        gravarArq.println("Tempo do Merge Sort em Array List: "+end+" ms");
        insertRandomNumbers();

        //Quick Sort em ArrayList
        start = System.currentTimeMillis();
        quickSortArrayList(arrayList,0,tamanho-1);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Quick Sort em Array List: "+end+" ms");
        gravarArq.println("Tempo do Quick Sort em Array List: "+end+" ms");
        insertRandomNumbers();

        //Collection.sort em ArrayList
        start = System.currentTimeMillis();
        Collections.sort(arrayList);
        end = System.currentTimeMillis() - start;
        System.out.println("Tempo do Java.sort em Array List: "+end+" ms");
        gravarArq.println("Tempo do Collection.sort em Array List: "+end+" ms");
        insertRandomNumbers();

        arq.close();
    }


    //print do resultado vetor
    public static void printVetor(){
        for(int i=0; i<tamanho; i++){
            System.out.print(vetorNumeros[i]+"\n");
        }
    }

    //funcao inicial para iniciar as listas
    public static void initLists(){
        for(int i=0; i<tamanho; i++){
            arrayList.add(i, 0);
            linkedList.add(i, 0);
        }
    }

    //funcao para adicionar numeros as variaveis
    public static void insertRandomNumbers(){
        Random aleatorio = new Random(96156906);
        int aux;
        for(int i=0; i<tamanho; i++){
            aux = aleatorio.nextInt(tamanho);
            vetorNumeros[i]=aux;
            arrayList.set(i, aux);
            linkedList.set(i, aux);
        }
    }


    //BubbleSort
    public static void bubbleSort(Integer[] vetor, int n) {
        boolean swap = false;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1-i; j++) {
                if(vetor[j]>vetor[j+1]) {
                    int aux = vetor[j];
                    vetor[j]=vetor[j+1];
                    vetor[j+1] = aux;
                    swap = true;
                }
            }
            if(swap) {
                swap = false;
            }else {
                break;
            }
        }
    }

    //selectionSort
    public static void selectionSort(Integer[] vetor, int n) {
        int menor;
        int idxMenor;

        for(int i=0; i<n-1; i++) {
            menor = vetor[i];
            idxMenor = i;
            for(int j=i+1; j<n; j++) {
                if(menor > vetor[j]) {
                    menor = vetor[j];
                    idxMenor = j;
                }
            }
            int aux = vetor[i];
            vetor[i] = menor;
            vetor[idxMenor] = aux;
        }
    }

    //insertionSort
    public static void insertionSort(Integer[] vetor, int n) {
        for(int i=1; i<n; i++) {
            int aux = vetor[i];
            for(int j=i; j>=0; j--) {
                if(j==0) {
                    vetor[j] = aux;
                    break;
                }
                if(aux<vetor[j-1]) {
                    vetor[j] = vetor[j-1];
                }else {
                    vetor[j] = aux;
                    break;
                }
            }
        }
    }

    //mergeSort
    static void mergeSort(Integer[] vetor, int inicio, int fim) {
        if(inicio == fim)
            return;
        int meio = (inicio+fim)/2;

        mergeSort(vetor, inicio, meio);

        mergeSort(vetor, meio+1, fim);

        merge(vetor, inicio, meio, fim);
    }

    //Merge
    static void merge(Integer[] vetor, int inicio, int meio, int fim) {
        int i = inicio;
        int j = meio+1;
        int k = 0;
        Integer[] vetAux = new Integer[fim-inicio+1];
        while(i<=meio && j<=fim) {
            if(vetor[i] < vetor[j]) {
                vetAux[k] = vetor[i];
                i++;
                k++;
            }else {
                vetAux[k] = vetor[j];
                j++;
                k++;
            }
        }
        while(i <= meio) {
            vetAux[k] = vetor[i];
            i++;
            k++;
        }
        while(j<=fim) {
            vetAux[k] = vetor[j];
            j++;
            k++;
        }
        for(k=0; k<fim-inicio+1; k++) {
            vetor[inicio+k] = vetAux[k];
        }
    }


    //QuickSort
    static void quickSort(Integer[] vetor, int inicio, int fim) {
        int i = inicio;
        int j = fim;
        int meio = (inicio+fim)/2;
        int pivo = vetor[meio];

        while(i <= j) {
            while(vetor[i] < pivo) {
                i++;
            }
            while(vetor[j] > pivo) {
                j--;
            }
            if( i <= j) {
                int aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
                i++;
                j--;
            }
        }
        if(inicio < j) {
            quickSort(vetor, inicio, j);
        }
        if(i < fim) {
            quickSort(vetor, i, fim);
        }
    }

    //bubbleSort LinkeList
    public static void bubbleSortLinkedList(LinkedList<Integer> linkedList, int n) {
        boolean swap = false;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1-i; j++) {
                if(linkedList.get(j)>linkedList.get(j+1)) {
                    int aux = linkedList.get(j);
                    linkedList.set(j, linkedList.get(j+1));
                    linkedList.set((j+1), aux);
                    swap = true;
                }
            }
            if(swap) {
                swap = false;
            }else {
                break;
            }
        }
    }

    //Selection Sort LinkedList
    public static void selectionSortLinkedList(LinkedList<Integer> linkedList, int n) {
        int menor;
        int idxMenor;

        for(int i=0; i<n-1; i++) {
            menor = linkedList.get(i);
            idxMenor = i;
            for(int j=i+1; j<n; j++) {
                if(menor > linkedList.get(j)) {
                    menor = linkedList.get(j);
                    idxMenor = j;
                }
            }
            int aux = linkedList.get(i);
            linkedList.set(i, menor);
            linkedList.set(idxMenor, aux);
        }
    }

    //insertionSort em LinkedList
    public static void insertionSortLinkedList(LinkedList<Integer> linkedList, int n) {
        for(int i=1; i<n; i++) {
            int aux = linkedList.get(i);
            for(int j=i; j>=0; j--) {
                if(j==0) {
                    linkedList.set(j, aux);
                    break;
                }
                if(aux<linkedList.get(j-1)) {
                    linkedList.set(j, linkedList.get(j-1));
                }else {
                    linkedList.set(j, aux);
                    break;
                }
            }
        }
    }


    //mergeSort em linkedList
    static void mergeSortLinkedList(LinkedList<Integer> linkedList, int inicio, int fim) {
        if(inicio == fim)
            return;
        int meio = (inicio+fim)/2;

        mergeSortLinkedList(linkedList, inicio, meio);

        mergeSortLinkedList(linkedList, meio+1, fim);

        mergeLinkedList(linkedList, inicio, meio, fim);
    }

    //Merge em LinkedList
    static void mergeLinkedList(LinkedList<Integer> linkedList, int inicio, int meio, int fim) {
        int i = inicio;
        int j = meio+1;
        int k = 0;
        LinkedList<Integer> vetAux = new LinkedList<>();
        while(i<=meio && j<=fim) {
            if(linkedList.get(i) < linkedList.get(j)) {
                vetAux.add(k, linkedList.get(i));
                i++;
                k++;
            }else {
                vetAux.add(k, linkedList.get(j));
                j++;
                k++;
            }
        }
        while(i <= meio) {
            vetAux.add(k, linkedList.get(i));
            i++;
            k++;
        }
        while(j<=fim) {
            vetAux.add(k, linkedList.get(j));
            j++;
            k++;
        }
        for(k=0; k<fim-inicio+1; k++) {
            linkedList.set((inicio+k),vetAux.get(k));
        }
    }

    //Quick Sort em LinkedList
    static void quickSortLinkedList(LinkedList<Integer> linkedList, int inicio, int fim) {
        int i = inicio;
        int j = fim;
        int meio = (inicio+fim)/2;
        int pivo = linkedList.get(meio);

        while(i <= j) {
            while(linkedList.get(i) < pivo) {
                i++;
            }
            while(linkedList.get(j) > pivo) {
                j--;
            }
            if( i <= j) {
                int aux = linkedList.get(i);
                linkedList.set(i, linkedList.get(j));
                linkedList.set(j, aux);
                i++;
                j--;
            }
        }
        if(inicio < j) {
            quickSortLinkedList(linkedList, inicio, j);
        }
        if(i < fim) {
            quickSortLinkedList(linkedList, i, fim);
        }
    }

    //bubbleSort ArrayList
    public static void bubbleSortArrayList(ArrayList<Integer> arrayList, int n) {
        boolean swap = false;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1-i; j++) {
                if(arrayList.get(j) > arrayList.get(j+1)){
                    int aux = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set((j + 1), aux);
                    swap = true;
                }
            }
            if(swap) {
                swap = false;
            }else {
                break;
            }
        }
    }


    //Selection Sort Array List
    public static void selectionSortArrayList(ArrayList<Integer> arrayList, int n) {
        int menor;
        int idxMenor;

        for(int i=0; i<n-1; i++) {
            menor = arrayList.get(i);
            idxMenor = i;
            for(int j=i+1; j<n; j++) {
                if(menor > arrayList.get(j)) {
                    menor = arrayList.get(j);
                    idxMenor = j;
                }
            }
            int aux = arrayList.get(i);
            arrayList.set(i, menor);
            arrayList.set(idxMenor, aux);
        }
    }

    //insertion Sort em ArrayList
    public static void insertionSortArrayList(ArrayList<Integer> arrayList, int n) {
        for(int i=1; i<n; i++) {
            int aux = arrayList.get(i);
            for(int j=i; j>=0; j--) {
                if(j==0) {
                    arrayList.set(j, aux);
                    break;
                }
                if(aux<arrayList.get(j-1)) {
                    arrayList.set(j, arrayList.get(j-1));
                }else {
                    arrayList.set(j, aux);
                    break;
                }
            }
        }
    }

    //mergeSort em ArrayList
    static void mergeSortArrayList(ArrayList<Integer> arrayList, int inicio, int fim) {
        if(inicio == fim)
            return;
        int meio = (inicio+fim)/2;

        mergeSortArrayList(arrayList, inicio, meio);

        mergeSortArrayList(arrayList, meio+1, fim);

        mergeArrayList(arrayList, inicio, meio, fim);
    }

    //Merge em ArrayList
    static void mergeArrayList(ArrayList<Integer> arrayList, int inicio, int meio, int fim) {
        int i = inicio;
        int j = meio+1;
        int k = 0;
        ArrayList<Integer> vetAux = new ArrayList<>();
        while(i<=meio && j<=fim) {
            if(arrayList.get(i) < arrayList.get(j)) {
                vetAux.add(k, arrayList.get(i));
                i++;
                k++;
            }else {
                vetAux.add(k, arrayList.get(j));
                j++;
                k++;
            }
        }
        while(i <= meio) {
            vetAux.add(k, arrayList.get(i));
            i++;
            k++;
        }
        while(j<=fim) {
            vetAux.add(k, arrayList.get(j));
            j++;
            k++;
        }
        for(k=0; k<fim-inicio+1; k++) {
            arrayList.set(inicio+k,vetAux.get(k));
        }
    }

    //Quick Sort em ArrayList
    static void quickSortArrayList(ArrayList<Integer> arrayList, int inicio, int fim) {
        int i = inicio;
        int j = fim;
        int meio = (inicio+fim)/2;
        int pivo = arrayList.get(meio);

        while(i <= j) {
            while(arrayList.get(i) < pivo) {
                i++;
            }
            while(arrayList.get(j) > pivo) {
                j--;
            }
            if( i <= j) {
                int aux = arrayList.get(i);
                arrayList.set(i, arrayList.get(j));
                arrayList.set(j, aux);
                i++;
                j--;
            }
        }
        if(inicio < j) {
            quickSortArrayList(arrayList, inicio, j);
        }
        if(i < fim) {
            quickSortArrayList(arrayList, i, fim);
        }
    }
}