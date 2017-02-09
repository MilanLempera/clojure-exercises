(ns clojure-exercises.spec.structures
  (:require [clojure.spec :as s]))


(s/conform (s/coll-of keyword?) [:a :b :c])

(s/conform (s/coll-of number?) #{5 10 2})

(s/def ::point (s/tuple double? string?))
(s/conform ::point [1.5 "test"])

(s/def ::ingredient (s/cat :quantity number? :unit keyword?))
(s/conform ::ingredient [2 :teaspoon])