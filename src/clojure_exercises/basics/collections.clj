(ns clojure-exercises.basics.collections)

(peek '(1 2 3 4 5))
(pop '(1 2 3 4 5))

(list? 'a)

(get [:a :b :c :d] 2)
(nth [:a :b :c :d] 3)

(peek [:a :b :c :d])
(rseq [:a :b :c :d])
(vector? [:a :b :c])
