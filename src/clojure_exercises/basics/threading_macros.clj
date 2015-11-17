(ns clojure-exercises.basics.threading-macros
  (:use [clojure.walk]))

(-> 1 inc inc)    ;; 3
(->> 1 inc inc)   ;; 3

(=
  (macroexpand-all '(-> 1 inc inc))
  (macroexpand-all '(->> 1 inc inc))
  '(inc (inc 1)))                     ;; true

(-> [1 2 3] (map inc) (map inc))      ;; chyba
(->> [1 2 3] (map inc) (map inc))     ;; (3 4 5)

(=
  (macroexpand-all '(-> [1 2 3] (map inc) (map inc)))
  '(map (map [1 2 3] inc) inc))       ;; true

(=
  (macroexpand-all '(->> [1 2 3] (map inc) (map inc)))
  '(map inc (map inc [1 2 3])))       ;; true

(macroexpand-all '(-> :data-as-first-arg (:f1 :arg-f1) (:f2 :arg-f2)))
;;  (:f2 (:f1 :data-as-first-arg :arg-f1) :arg-f2)


(macroexpand-all '(->> :data-as-last-arg (:f1 :arg-f1) (:f2 :arg-f2)))
;; (:f2 :arg-f2 (:f1 :arg-f1 :data-as-last-arg))