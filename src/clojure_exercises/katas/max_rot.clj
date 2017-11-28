; https://www.codewars.com/kata/rotate-for-a-max/train/clojure

(ns maxrot.core
  (:require [clojure.string :as string]))

(defn rotate [items]
  (let [length (count items)
        rest (drop 1 (cycle items))]
    (take length rest)))

(defn sliding-rotate [{step        :step
                        last-value :value}]

  (let [number-seq (seq (str last-value))
        [fixed to-rotation] (split-at step number-seq)
        rotated (rotate to-rotation)
        str-number (apply str (concat fixed rotated))]
    {:step  (inc step)
     :value (bigint str-number)}))

(defn max-rot [n]
  (let [init {:step  0
              :value n}
        length (count (str n))
        numbers-seq (iterate sliding-rotate init)
        numbers (->> numbers-seq
                     (take length)
                     (map :value))]
    (apply max numbers)))

(max-rot 69418307)

(= (max-rot 38458215) 85821534)
(= (max-rot 195881031) 988103115)
(= (max-rot 69418307) 94183076)

;
;(deftest a-test1
;  (testing "max-rot"
;    (test-assert(max-rot 38458215) 85821534)
;    (test-assert(max-rot 195881031) 988103115)
;    (test-assert(max-rot 896219342) 962934281)
;    (test-assert
;    ))

