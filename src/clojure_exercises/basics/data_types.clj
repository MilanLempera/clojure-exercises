(ns clojure-exercises.basics.data-types
  (:gen-class))

; char
\a
; string
"string"
; integer
11
(type 11)
; double
11.1
; boolean
true
; nil
nil
; symbol
'foo
; keyword
:keyword

(= '(1 2 3) (list 1 2 3) )

(= [1 2 3] (vector 1 2 3) )

(= {:a 1 :b 2} (hash-map :a 1 :b 2))

(= #{1 2 3} (hash-set 1 2 3))

(def someHashMap
  {:a 1 :b 2})

; maps can be used as function
(someHashMap :a)
(someHashMap :unknown)



