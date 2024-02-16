package additionalTasks.Task3Part2;

public class SweetSurprise {
    public static void main(String[] args) {
        //Создаем экземпляры сладостей
        Chocolate mars = new Chocolate("Марс", 44.99, 50, "Mars Incorporated");
        Sweets cotton = new Sweets("Сахарная вата", 67.99, 30);
        Candy skittles = new Candy("Скиттлс", 52, 38, 4);
        Lemonade mountainDew = new Lemonade();
        mountainDew.setName("Маунтин дью");
        mountainDew.setPrice(124.75);
        mountainDew.setWeight(1050);
        mountainDew.setVolume(1000);

        //Инициируем массив(подарок) с вкусностями и стрингу для вывода информации
        Sweets[] present = new Sweets[]{mars, cotton, skittles, mountainDew};
        StringBuilder presentInfo = new StringBuilder();

        // Определяем общую стоимость и вес подарка, а также собираем информацию для вывода в консоль.
        double surprisePrice = 0;
        int surpriseWeight = 0;
        for (Sweets sweet : present) {
            surprisePrice += sweet.getPrice();
            surpriseWeight += sweet.getWeight();
            presentInfo.append(sweet).append("\n");
        }

        // Блок вывода информации
        System.out.println("\nИнформация о подарке ↓↓↓");
        System.out.println("Сладкий подарок содержит:");
        System.out.println(presentInfo);
        System.out.printf("Общая стоимость подарка = %.2f; Общий вес подарка = %d", surprisePrice, surpriseWeight);
    }
}
