(ns file-tracker.core
  (:import java.io.File))

;;Get Last modified timestamp
(defn last-modified [file-path]
 (let [f (File. file-path)] 
  (if (.isDirectory f)
    (max (.lastModified f) (apply max (map last-modified (.list f))))
    (.lastModified f))))

(defn create-file-modified-map [file-paths]
 (into {} (map (fn [f] {(keyword f) (last-modified f)}) file-paths)))

(defn updated-files [old-map new-map]
  (map first 
       (filter (fn [f] (not= ((first f) new-map) 
                           (second f))) old-map)))

(defn file-tracker
  ([file-paths]
   (file-tracker file-paths (create-file-modified-map file-paths)))
  ([file-paths initial-map]
   (let [time-map (atom initial-map)]
     (fn []
       (let [old-map @time-map
             new-map (create-file-modified-map file-paths)
             change-files (updated-files old-map new-map)]
         (reset! time-map new-map)
         change-files)))))
