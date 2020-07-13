(ns concurrent-graph.core)

(defn concurrent-graph []
  (atom {}))

(defn add-vertex [graph vertex]
  (swap! graph assoc vertex #{}))

(defn add-edge [graph v1 v2]
  (swap! graph #(update % v1 conj v2))
  (swap! graph #(update % v2 conj v1)))
