package com.java8.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionDemo {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(new Product("GOOG",345.00,"IT","A"),
                new Product("GOOG",1200.00,"IT","A"),
                new Product("GOOG",1001.00,"IT","A"),
                new Product("GOOG",1000.00,"IT","A"));
        printProductsPriceGreaterThanThousand(products);
        printCostOfAllProducts(products);
    }

    private static void printCostOfAllProducts(List<Product> products) {
        Function<List<Product> ,Double> costOfAllProducts = products1 -> products1.stream()
                                                                                  .map(Product::getPrice)
                                                                                  //.reduce(0.0,(total,price)->total+price);
                                                                                  //.reduce(0.0,(total,price)->Double.sum(total,price));
                                                                                    .reduce(0.0,Double::sum);
        System.out.println(costOfAllProducts.apply(products));
    }

    private static void printProductsPriceGreaterThanThousand(List<Product> products) {
        Predicate<Product> isProductPriceGreaterThanThousand = product -> product.getPrice()>1000;
        products.stream().filter(product -> isProductPriceGreaterThanThousand.test(product)).forEach(System.out::println);
    }





}
