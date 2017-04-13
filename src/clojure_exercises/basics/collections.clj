(ns clojure-exercises.basics.collections
  (:import (clojure.lang PersistentQueue)))

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

(cons 0 '(1 2))
(conj '(1 2) 0)

(peek '(1 2 3 4 5))
(first '(1 2 3 4 5))

(pop '(1 2 3 4 5))
(next '(1 2 3 4 5))

(list? 'a)

; persistent queue
; does not have print

(defmethod print-method clojure.lang.PersistentQueue
  [q w]

  (print-method '<- w)
  (print-method (seq q) w)
  (print-method '-< w))

(def steps (conj clojure.lang.PersistentQueue/EMPTY :first-step :second-step :third-step))
(peek steps)
(pop steps)
(rest steps)                                                ; returns sequnce not PersistentQueue

; persistent set

(#{:a :b :c} :b)
(#{:a :b :c} :f)

(get #{:a :b :c} :a)
(get #{:a :b :c} :f )






(get [:a :b :c :d] 2)
(nth [:a :b :c :d] 3)

(rseq [:a :b :c :d])
