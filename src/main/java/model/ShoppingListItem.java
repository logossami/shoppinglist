package model;

public class ShoppingListItem {

    private long id;
    private String title;

    @SuppressWarnings("unused")
    public ShoppingListItem() {
    }

    public ShoppingListItem(long id, String title) {
        this.id = id;
        this.title = title;
    }
    
    public ShoppingListItem(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public void setTuote(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    
    @Override
	public String toString() {
		return title;
	}

	@Override
    public boolean equals(Object other) {
        return other instanceof ShoppingListItem && ((ShoppingListItem) other).id == this.id;
    }
}
