package polymorphism;

public class App {
    public static void main(String args[]) {
        Plant plant1 = new Plant();
        plant1.grow(); 
        // Tree is a kind of Plant (it extends Plant)
        Tree tree1 = new Tree();
        tree1.grow();
        // Polymorphism guarantees that we can use a child class
        // wherever a parent class is expected.
        Plant plant2 = tree1;
        
        // plant2 references a Tree, so the Tree grow() method is called.
        plant2.grow();
        
        // The type of the reference decided what methods you can actually call;
        // we need a Tree-type reference to call tree-specific methods.
        tree1.seed();
        
        // ... so this won't work.
        //plant2.seed();

        //can not reference parent with child name.
        //Tree tree2=plant1;
        
        // Another example of polymorphism.
        doGrow(tree1);
    }
    
    public static void doGrow(Plant plant) {
        plant.grow();
        //plant.seed();
    }

}
