(ns clojure-exercises.basics.merge-maps)


(=
  (merge {:a 1 :b 2 :c 3} {:b 9 :d 4})
  {:d 4, :c 3, :b 9, :a 1})

(= (merge-with + {:a 1 :b 2 :c 3} {:b 9 :d 4})
   {:d 4, :c 3, :b 11, :a 1})



