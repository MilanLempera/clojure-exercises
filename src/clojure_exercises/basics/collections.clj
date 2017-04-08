(ns clojure-exercises.basics.collections)

; vectors

(vec (range 10))

(def my-vector [:a :b :c])

(into my-vector (range 3))

(vector 1 2 3)

(map vector (range -10 0) (range 0 10))

(nth my-vector 1)
(get my-vector 1)
(my-vector 1)

(assoc my-vector 1 :B)

;for nested vector/structures get-in, update-in, assoc-in

; vector as a stack

(def vstack [1 2 3])
(peek vstack)                                               ; 3
(pop vstack)                                                ; [1 2]
(conj vstack 4)                                             ; [1 2 3 4]

; use peek last will be slower

(def number (vec (range 20)))

(subvec number 7 12)

; lists

(peek '(1 2 3 4 5))
(pop '(1 2 3 4 5))

(list? 'a)

(get [:a :b :c :d] 2)
(nth [:a :b :c :d] 3)

(peek [:a :b :c :d])
(rseq [:a :b :c :d])
(vector? [:a :b :c])
