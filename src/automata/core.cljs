(ns automata.core
  (:require [dommy.core :as dommy :refer-macros [sel sel1]]))

(enable-console-print!)

;;;;;;;;
;; Utils
(defn random-binary
  "Returns a random 0 or 1"
  []
  (rand-int 2))

;;;;;;;;;;;;
;; Constants
(def width 80)

;;;;;;;;;
;; Set up
(defn random-class-div
  []
  (let [el (dommy/create-element :div)
        cl (if (= 0 (random-binary))
             :inactive
             :active)]
    (dommy/add-class! el cl)))

(defn expand-row!
  "Creates n divs inside of a parent row"
  [row n]
  (doseq [i (range n)]
    (let [el (random-class-div)
          div (sel1 :.row)]
      (dommy/append! div el))))

(defn seed-automata
  [size]
  (let [automata (sel1 :div)]
    (as-> (dommy/create-element :div) row
      (dommy/add-class! row :row)
      (dommy/append! automata row)
      (expand-row! row size))))

(seed-automata 80)

;;;;;;;;;;;;;;;;;;
;; Do the automata

;; read the last row
;; process above row
;; build the next row

(comment

  To read the row is easy.
  1. Select the row (last (sel :.row))
  2. Get a vector of 1s and 0s (map #(into [] (cond (= (has-class "active" %)) 1 0)))

  To process the row is tricky
  1. Get the element
  2. Get the neighboring elements
  3. Put them into a vector like [a b c]
  4. Match the rule patterns to get the activity of child
  6. Put 1 or 0 into []
  7. Build the next row

  To build the next row
  1. Build row div
  2. Expand row div
  3. Apply the correct class for that spot
)
