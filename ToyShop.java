package Final_of_Block_P1_Java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

class Toy {
    int id;
    String name;
    int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }
}

public class ToyShop {
    public static void main(String[] args) {
        // Создание коллекции для хранения игрушек
        PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> t2.weight - t1.weight);

        // Добавление игрушек в очередь
        toyQueue.add(new Toy(1, "робот", 2));
        toyQueue.add(new Toy(2, "конструктор", 2));
        toyQueue.add(new Toy(3, "кукла", 6));

        // Вызов метода Get 10 раз и запись результатов в файл
        try {
            FileWriter writer = new FileWriter("results.txt");
            Random random = new Random();
            
            for (int i = 0; i < 10; i++) {
                Toy selectedToy = getRandomToy(toyQueue, random);
                writer.write(selectedToy.id + " " + selectedToy.name + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для получения случайной игрушки с учетом весов
    private static Toy getRandomToy(PriorityQueue<Toy> toyQueue, Random random) {
        int randomPercentage = random.nextInt(100) + 1;
        
        Toy selectedToy;
        
        if (randomPercentage <= 20) {
            selectedToy = getToyById(toyQueue, 1); // игрушка с id 1
        } else if (randomPercentage <= 40) {
            selectedToy = getToyById(toyQueue, 2); // игрушка с id 2
        } else {
            selectedToy = getToyById(toyQueue, 3); // игрушка с id 3
        }
        
        return selectedToy;
    }
    
    private static Toy getToyById(PriorityQueue<Toy> toyQueue, int id) {
        for (Toy toy : toyQueue) {
            if (toy.id == id) {
                return toy;
            }
        }
        return null;
    }
}    






