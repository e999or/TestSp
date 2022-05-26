public class Test {
    public  void sort (int[] a, int p, int r){
        if (p < r){
            int q = Math.round(((p + r)/ 2));
            sort(a, p, q);
            sort(a, q + 1, r);
            merge(a, p - 1, q - 1, r - 1);
        }
    }

    private void merge(int[] a, int p, int q, int r) {
        // вычисляем длину
        int lenL = q - p + 1;
        int lenR = r - q;

        // создаем временные подмассивы
        int lArr[] = new int[lenL];
        int rArr[] = new int[lenR];

        // копируем отсортированные массивы во временные
        for (int i = 0; i < lenL; i++)
            lArr[i] = a[p + i];
        for (int i = 0; i < lenR; i++)
            rArr[i] = a[q + i + 1];

        // итераторы содержат текущий индекс временного подмассива
        int lIndex = 0;
        int rIndex = 0;

        // копируем из lArr и rArr обратно в массив
        for (int i = p; i < r + 1; i++) {
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (lIndex < lenL && rIndex < lenR) {
                if (lArr[lIndex] < rArr[rIndex]) {
                    a[i] = lArr[lIndex];
                    lIndex++;
                } else {
                    a[i] = rArr[rIndex];
                    rIndex++;
                }
            }
            // если все элементы были скопированы из rArr, скопировать остальные из lArr
            else if (lIndex < lenL) {
                a[i] = lArr[lIndex];
                lIndex++;
            }
            // если все элементы были скопированы из lArr, скопировать остальные из rArr
            else if (rIndex < lenR) {
                a[i] = rArr[rIndex];
                rIndex++;
            }
        }

        System.out.println(a + " " + p + " " + q + " " + r);
        for (int i : a) {
            System.out.print(i);
        }
    }

    public static void main(String[] args) {

        Test test = new Test();
        int[] a ={5,2,4,6,1,3,2,6};
        test.sort(a,1, a.length);

    }
}
