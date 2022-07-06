
// дан массив из целых неповторяющихся чисел
// на выходе получить строку содержащую диапазоны чисел в данном массиве
// дан {1,4,5,2,3,9,8,11,0}
// получить "0-5,8-9,11"
class Exec {
    int[] a;
    // конструктор - присвоение данных массиву
    Exec(int[] aa){ a=aa;}
    // метод - сортировка массива
    int[] sort(int[] a){
        //int[] b=new int[a.length];
        int m, c;//номер миним числа, переменная для обмена местами
        for(int i=0;i<a.length;i++){
            m=i;//номер миним числа присваиваем  первому в текущем цикле просмотра
            for(int j=i;j<a.length;j++){
               if(a[m]>=a[j]) {
                  m=j;
               }
            }
            //найденное минимальное меняем с текущим первым в переменной i
            c=a[i];a[i]=a[m];a[m]=c;
        }
        return a;
    }
    //формирование строки с диапазонами
    String diap(){
       String ss=String.valueOf(a[0]);
       int m=a[0],km=1;//первое число в диапазоне, колво чисел в диапазоне
       for(int i=1;i<a.length;i++){
            if(m+1 != a[i]){
               if (km==1) {
                   ss=ss+","+String.valueOf(a[i]);
                   m=a[i];
               }
               else{
                   ss=ss+"-"+String.valueOf(m)+","+String.valueOf(a[i]);
                   m=a[i];km=1;
               }
            }
            else{
                m++;km++;
            }

       }
       return ss;
    }

}
public class int_diap{
    public static void main(String[] args){
        int[] a={1,4,5,2,3,9,8,11,0,12,14};// здесь собственно задаем данный массив чисел
        Exec e = new Exec(a);
        for(int m:e.a){
            System.out.print(m+" ");
        }
        System.out.println();
        for(int m:e.sort(a)){
            System.out.print(m+" ");
        }
        System.out.println();
        System.out.println(e.diap());
    }
}
