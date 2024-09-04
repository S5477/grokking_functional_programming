package main

import (
	"sort"
	"strings"
)

func main() {
	cities := []string{"Paris", "Berlin", "London", "Rome", "Madrid"}
	words := rankerWords(wordSorter, score, cities)

	for _, word := range words {
		println(word)
	}

	for _, word := range cities {
		println(word)
	}
}

func rankerWords(wordSort func([]string, func(string) int) []string, wordScore func(string) int, words []string) []string {
	newArr := make([]string, len(words))
	newArr = words
	wordSort(newArr, wordScore)

	return newArr
}

func wordSorter(words []string, sortf func(string) int) []string {
	sort.Slice(words, func(i, j int) bool {
		return sortf(words[i]) > sortf(words[j])
	})

	return words
}

func score(word string) int {
	return len(strings.ReplaceAll(word, "a", ""))
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
