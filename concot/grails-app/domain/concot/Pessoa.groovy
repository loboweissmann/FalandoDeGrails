package concot

abstract class Pessoa {
	String nome

	static mapping = {
		tablePerHierarchy false
	}
}