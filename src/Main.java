public class Main {
    public static void main(String[] args) {
        Node node = new Node();
        // System.out.println(node.hashCode()); // генерируется из адреса, где лежит объект. Индекс нашего объекта в массиве.
        // HashMap выделяет массив размером 16 элементов.
        MyList myList = new MyList();

        for (int i = 0; i < 32; i++) {
            //myList.put(new Random().nextInt(Integer.MAX_VALUE), 22));
            myList.put(i, i+1);
        }

        System.out.println("Получаем значение по ключу: " + myList.get(30));
        System.out.println("Заменяем значение по ключу на 12");
        myList.replace(30,12);
        System.out.println("Теперь значение по ключу равно: " + myList.get(30));
        System.out.println("Удаляем значение: " + myList.remove(30));
        System.out.println("Теперь значение по ключу равно: " + myList.get(30));
        System.out.println("Размер массива равен: " + myList.size());
        System.out.println("Проверяем, есть ли элемент по key: " + myList.containsKey(30));
        System.out.println("Ещё раз проверяем, есть ли элемент по key: " + myList.containsKey(3));
        System.out.println("Проверяем, есть ли элемент по value: " + myList.containsValue(5));
        System.out.println("Ещё раз проверяем, есть ли элемент по value: " + myList.containsValue(36));

        }

}