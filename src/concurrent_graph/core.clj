(ns concurrent-graph.core)

(defn concurrent-graph []
  (atom {}))

(defn add-vertex [graph vertex]
  (swap! graph assoc vertex #{}))
