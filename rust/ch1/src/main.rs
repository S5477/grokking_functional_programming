use std::collections::LinkedList;

struct ShoppingCart<T: PartialEq + AsRef<str>> {
    items: LinkedList<T>,
}

impl<T: PartialEq + AsRef<str>> ShoppingCart<T> {
    fn new() -> Self {
        ShoppingCart {
            items: LinkedList::new(),
        }
    }

    fn add_item(mut self, item: T) -> Self {
        self.items.push_back(item);
        self
    }

    fn get_discount_percentage(&self) -> i32 {
        if self.items.iter().any(|item| item.as_ref() == "Book") {
            5
        } else {
            0
        }
    }
}

fn main() {
    let cart = ShoppingCart::new()
        .add_item("Pen".to_string())
        .add_item("Book".to_string());

    println!("Discount percentage: {}", cart.get_discount_percentage());
}
