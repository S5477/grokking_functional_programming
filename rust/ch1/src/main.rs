use std::collections::LinkedList;

struct ShoppingCart<T> {
    items: LinkedList<T>,
}

impl<T: PartialEq + AsRef<str>> ShoppingCart<T> {
    fn new() -> Self {
        ShoppingCart {
            items: LinkedList::new(),
        }
    }

    fn add_item(&mut self, item: T) {
        self.items.push_back(item);
    }

    fn get_cart(&mut self) -> LinkedList<T> {
        self.items
    }

    fn get_discount_percentage(items:LinkedList<T>) -> i32 {
        if self.items.iter().any(|item| item.as_ref() == "Book") {
            5
        } else {
            0
        }
    }
}

fn main() {
    let mut cart = ShoppingCart::new();

      cart.add_item("Pen".to_string());


    let discount = cart.get_discount_percentage(cart.get_cart());
    println!("Discount percentage: {}", discount);

    cart.add_item("Book".to_string());

    let discount = cart.get_discount_percentage(cart.get_cart());
    println!("Discount percentage: {}", discount);
}
