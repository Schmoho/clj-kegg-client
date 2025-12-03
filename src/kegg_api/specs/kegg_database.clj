(ns kegg-api.specs.kegg-database
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def kegg-database-data
  {
   })

(def kegg-database-spec
  (ds/spec
    {:name ::kegg-database
     :spec kegg-database-data}))
