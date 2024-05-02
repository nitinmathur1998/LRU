public interface Cache {

    default int get(int key) {
        return 0;
    }

    default void put(int key, int value) {
    }

    default void addNode(Node node){
    }

    default void deleteNode(Node node) {
    }
}


