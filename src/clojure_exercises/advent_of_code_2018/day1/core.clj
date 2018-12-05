(ns clojure-exercises.advent-of-code-2018.day1.core
  (:require [clojure.string :as str]))

(defn- file-as-numbers [text]
  (->> text
       (str/split-lines)
       (map read-string)))

(defn calculate-frequency [text]
  (->> (file-as-numbers text)
       (reduce + 0)))

(defn find-repeated-number [numbers]
  (loop [used-numbers #{}
         current-number (first numbers)
         number-sequence (next numbers)]
    (if (used-numbers current-number)

      current-number

      (recur (conj used-numbers current-number)
             (first number-sequence)
             (rest number-sequence)))))

(defn find-repetition [text]
  (->> (file-as-numbers text)
       cycle
       (reductions +)
       find-repeated-number))

;------------------------------------

(def input (slurp "/Users/milanlempera/projects/training/clojure/clojure-exercises/src/clojure_exercises/advent_of_code_2018/day1/input.txt"))

(calculate-frequency input)

(find-repetition input)