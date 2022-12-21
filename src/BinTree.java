public class BinTree {
    Data data;
    BinTree left;
    BinTree right;

    public BinTree(Data data) {
        this.data = data;
    }

    public void AddData(Data new_data) {
        if (new_data.id < data.id) {
            if (left == null) left = new BinTree(new_data);
            else left.AddData(new_data);
        } else {
            if (right == null) right = new BinTree(new_data);
            else right.AddData(new_data);
        }
    }

    public Data FindData(int id) {
        if (data.id == id) return data;
        if (id < data.id) {
            if (left == null) return null;
            return left.FindData(id);
        } else {
            if (right == null) return null;
            return right.FindData(id);
        }
    }
}

class Data {
    int id;
    int data;

    public Data(int id, int data) {
        this.data = data;
        this.id = id;
    }
}