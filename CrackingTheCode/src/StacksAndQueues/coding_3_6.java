package StacksAndQueues;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by amritachowdhury on 6/22/17.
 */
public class coding_3_6 {

    public enum animalType {
        DOG,
        CAT
    }

    public class AnimalData {
        String name; animalType type; Date entryDate;

        public AnimalData(String name, animalType type) {
            this.name = name;
            this.type = type;
            this.entryDate = new Date();
        }

        public AnimalData() {}

        public void printAnimal() {
            System.out.println(this.name);
        }
    }

    public class AnimalShelter {
        LinkedList<AnimalData> dogQueue, catQueue;

        public AnimalShelter() {
            dogQueue = new LinkedList<>();
            catQueue = new LinkedList<>();
        }

        public void enqueue(AnimalData animal) throws Exception {
            if (animal.type == animalType.DOG) {
                dogQueue.add(animal);
            } else if (animal.type == animalType.CAT) {
                catQueue.add(animal);
            } else {
                throw new Exception("This is animal shelter for only cats and dogs!");
            }
        }

        public AnimalData deQueueDog() {
            return dogQueue.poll();
        }

        public AnimalData deQueueCat() {
            return catQueue.poll();
        }

        public AnimalData deQueueAny() {
            AnimalData dog = dogQueue.peek();
            AnimalData cat = catQueue.peek();
            return dog.entryDate.compareTo(cat.entryDate) < 0 ? dogQueue.poll() : catQueue.poll();
        }


    }

    public void run() {
        try {
            AnimalData adoptedAnimal;
            AnimalShelter shelter = new AnimalShelter();
            shelter.enqueue(new AnimalData("cat-1", animalType.CAT));
            shelter.enqueue(new AnimalData("cat-2", animalType.CAT));
            shelter.enqueue(new AnimalData("dog-1", animalType.DOG));
            shelter.enqueue(new AnimalData("cat-3", animalType.CAT));

            shelter.enqueue(new AnimalData("dog-2", animalType.DOG));
            shelter.enqueue(new AnimalData("dog-3", animalType.DOG));
            adoptedAnimal = shelter.deQueueAny();
            adoptedAnimal.printAnimal();
            adoptedAnimal = shelter.deQueueAny();
            adoptedAnimal.printAnimal();
            adoptedAnimal = shelter.deQueueDog();
            adoptedAnimal.printAnimal();
            adoptedAnimal = shelter.deQueueCat();
            adoptedAnimal.printAnimal();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
