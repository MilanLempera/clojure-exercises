(ns clojure-exercises.fizzbuzz.core)

(defn fizz-buzz-number [number]
  (cond
    (= 0 (mod number 3) (mod number 5)) :fizzbuzz
    (= 0 (mod number 3)) :fizz
    (= 0 (mod number 5)) :buzz
    :number number))

(defn fizzbuzz [n]
  (map fizz-buzz-number (range 1 (inc n))))

(fizzbuzz 15)