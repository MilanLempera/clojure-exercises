(ns clojure-exercises.sicp.basics)

(defn square [n]
  (* n n))

(defn f [g]
  (g 2))

(f square)

(f f)

(defn my-compose-simple [f1 f2]
  (fn [v]
    (f1 (f2 v))))

(defn my-compose [f1 f2]
  (fn [& args]
    (f1 (apply f2 args))))

(defn double [f]
  (my-compose f f))

(def double-inc (double inc))

(double-inc 2)

((double (double inc)) 1)

(((double (double double)) inc) 1)

((my-compose inc +) 1 2 3)

((comp inc +) 1 2 3)
