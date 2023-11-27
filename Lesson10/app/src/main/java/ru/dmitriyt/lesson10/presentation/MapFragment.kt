package ru.dmitriyt.lesson10.presentation

import android.graphics.PointF
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Geometry
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.ClusterListener
import com.yandex.mapkit.map.ClusterizedPlacemarkCollection
import com.yandex.mapkit.map.IconStyle
import com.yandex.mapkit.map.PlacemarkMapObject
import com.yandex.runtime.image.ImageProvider
import ru.dmitriyt.lesson10.R
import ru.dmitriyt.lesson10.databinding.FragmentMapBinding
import ru.dmitriyt.lesson10.databinding.ViewMapPinBinding
import ru.dmitriyt.lesson10.presentation.extensions.toBitmap

private const val YANDEX_ZOOM_REDUCTION_COEFFICIENT = 0.8f

class MapFragment : Fragment(R.layout.fragment_map) {
    private val binding by viewBinding(FragmentMapBinding::bind)

    private val mapPinViewBinding by lazy { ViewMapPinBinding.inflate(layoutInflater) }

    private val mapPinSize by lazy { resources.getDimensionPixelSize(R.dimen.map_pin_size) }

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { granted ->
        val isGranted = granted.values.any()
        if (isGranted) {

        }
    }

    private val clusterListener = ClusterListener { cluster ->
        mapPinViewBinding.textViewName.text = cluster.size.toString()
        cluster.addClusterTapListener { selectedCluster ->
            val points = selectedCluster.placemarks.map { it.geometry }
            val boundingBoxBuilder = BoundingBoxBuilder().apply {
                points.forEach { point ->
                    include(point)
                }
            }
            val boundingBoxCameraPosition = binding.mapView.mapWindow.map.cameraPosition(
                Geometry.fromBoundingBox(boundingBoxBuilder.build()),
                0f,
                0f,
                binding.mapView.mapWindow.focusRect
            )
            val targetCameraPosition = CameraPosition(
                boundingBoxCameraPosition.target,
                boundingBoxCameraPosition.zoom - YANDEX_ZOOM_REDUCTION_COEFFICIENT,
                boundingBoxCameraPosition.azimuth,
                boundingBoxCameraPosition.tilt,
            )
            binding.mapView.mapWindow.map.move(targetCameraPosition)
            true
        }
        cluster.appearance.setIcon(
            ImageProvider.fromBitmap(mapPinViewBinding.root.toBitmap(mapPinSize))
        )
    }
    private var collection: ClusterizedPlacemarkCollection? = null
    private val mapObjects = mutableMapOf<PlacemarkMapObject, Pair<String, Point>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.initialize(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        permissionLauncher.launch(
            arrayOf(
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
            )
        )
        binding.mapView.mapWindow.map.move(
            CameraPosition(Point(51.534018, 46.000089), 13f, 0f, 0f)
        )
        // 51.537612, 46.002424
        // 51.540361, 45.996716
        // 51.550289, 46.012337
        // 51.534595, 46.051734
        val stores = listOf(
            Point(51.534018, 46.000089),
            Point(51.537612, 46.002424),
            Point(51.540361, 45.996716),
            Point(51.550289, 46.012337),
            Point(51.534595, 46.051734),
        ).mapIndexed { index, point ->
            "M$index" to point
        }
        collection = binding.mapView.mapWindow.map.mapObjects
            .addClusterizedPlacemarkCollection(clusterListener)
        stores.forEach { store ->
            val (name, point) = store
            collection?.addPlacemark()?.apply {
                geometry = point
                mapPinViewBinding.textViewName.text = name
                setIcon(
                    ImageProvider.fromBitmap(mapPinViewBinding.root.toBitmap(mapPinSize))
                )
                setIconStyle(IconStyle().apply {
                    anchor = PointF(0.5f, 1f)
                })
                addTapListener { mapObject, _ ->
                    mapObjects[mapObject]?.let { store ->
                        Toast.makeText(context, "store = ${store.first}", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                mapObjects[this] = store
            }
        }
        collection?.clusterPlacemarks(40.0, 15)
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapView.onStart()
    }

    override fun onStop() {
        binding.mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onDestroyView() {
        collection?.clear()
        binding.mapView.mapWindow.map.mapObjects.clear()
        super.onDestroyView()

    }
}