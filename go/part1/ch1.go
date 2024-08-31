package main

func main() {
	cart := ShoppingCart{}

	cart.addItem("Phone")
	println(cart.getDiscountPercentage(cart.items))
	cart.addItem("Book")
	println(cart.getDiscountPercentage(cart.items))
}

type ShoppingCart struct {
	items []string
}

func (*ShoppingCart) getDiscountPercentage(items []string) int {
	if isset(items, func(item string) bool {
		return item == "Book"
	}) {
		return 5
	} else {
		return 0
	}
}

func (cs *ShoppingCart) addItem(item string) {
	cs.items = append(cs.items, item)
}

func isset(items []string, filter func(string) bool) bool {
	res := false

	for _, item := range items {
		if filter(item) {
			res = true
		}
	}

	return res
}
