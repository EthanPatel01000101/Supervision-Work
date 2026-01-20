import java.util.ArrayList;

public class Board<T> {
    private ArrayList<T> arr;
    private int width;
    private int height;

    public Board(int inWidth, int inHeight, T defaultElement) {
        arr = new ArrayList<T>(inWidth * inHeight);
        for (int i = 0; i < inWidth * inHeight; i++) {
            arr.add(defaultElement);
        }
        width = inWidth;
        height = inHeight;
    }

    public boolean validPosition(int x, int y) {
        if ((0 <= x) && (x < width)) {
            if ((0 <= y) && (y < height)) {
                return true;
            }
        }
        return false;
    }

    public T accessPosition(int x, int y) {
        if (validPosition(x, y)) {
            return arr.get((y * width) + x);
        }
        return arr.get(0);
    }

    public void changeAtPosition(int x, int y, T newData) {
        if (validPosition(x, y)) {
            arr.set((y * width) + x, newData);
        }
        
        //TODO: Flag an index error
    }

    public ArrayList<T> getRow(int y) {
        ArrayList<T> ans = new ArrayList<>();
        if ((0 <= y) && (y < height)) {
            for (int i = 0; i < width; i++){
                ans.add(arr.get(y * width + i));
            }
        }
        return ans;
    }

    public ArrayList<T> getColumn(int x) {
        ArrayList<T> ans = new ArrayList<>();
        if ((0 <= x) && (x < height)) {
            for (int i = 0; i < width; i++){
                ans.add(arr.get(x + (height * i)));
            }
        }
        return ans;
    }

    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public ArrayList<T> getBoard() {return arr;}
}