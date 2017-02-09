(ns clojure-exercises.spec.basics
  (:require [clojure.spec :as s]))

(s/conform even? 1)

(s/conform even? 10)

(s/valid? even? 1)

(s/valid? even? 10)


(s/def ::three-digit-int
  (s/and int?
         #(> % 99)))

(s/explain ::three-digit-int 99)

(s/def ::name-or-id (s/or :name string?
                          :id int?))

(s/conform ::name-or-id 10)
(s/valid? ::name-or-id 10)

(s/conform ::name-or-id "name")

(s/conform ::name-or-id 1.25)


(def email-regex #"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,63}$")
(s/def ::email-type (s/and string? #(re-matches email-regex %)))

(s/def ::acctid int?)
(s/def ::first-name string?)
(s/def ::last-name string?)
(s/def ::email ::email-type)

(s/def ::person (s/keys :req [::first-name ::last-name ::email]
                        :opt [::phone]))

(s/explain ::person {::first-name "Pavel"
                     ::last-name  "Novák"
                     ::phone      566666666})

(s/conform ::person {::first-name "Pavel"
                     ::last-name  "Novák"
                     ::email      "a@b.cz"
                     ::phone      566666666})


(s/def :unq/person (s/keys :req-un [::first-name ::last-name ::email]
                           :opt-un [::phone]))


(s/conform :unq/person {:first-name "Pavel"
                        :last-name  "Novák"
                        :email      "a@b.cz"
                        :phone      566666666})

(defrecord Person [first-name last-name email phone])
(s/conform :unq/person
           (->Person "Elon" "Musk" "elon@example.com" nil))


