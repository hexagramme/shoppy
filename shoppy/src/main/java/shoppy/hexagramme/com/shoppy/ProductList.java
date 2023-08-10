package shoppy.hexagramme.com.shoppy;
import java.util.ArrayList;

class ProductList {
    private ArrayList<Product> prodList = new ArrayList<Product>();

    public ArrayList<Product> getProdList(){
        return prodList;
    }
    public void setProdList(ArrayList<Product> newList) {
        prodList = newList;
    }
}
