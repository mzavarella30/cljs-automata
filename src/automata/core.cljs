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

;; duplicate the row

;; process the row

;; repeat
