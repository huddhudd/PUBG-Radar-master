package pubg.radar.struct

class Item {
    companion object {
        val category = mapOf(
            "Attach" to mapOf(
                "Weapon" to mapOf(
                    "Lower" to mapOf(
                        "AngledForeGrip" to "A.Grip",
                        "Foregrip" to "V.Grip"
                    ),
                    "Magazine" to mapOf(
                        "Extended" to mapOf(
                            "Medium" to "U.Ext",
                            "Large" to "AR.Ext",
                            "SniperRifle" to "S.Ext"
                        ),
                        "ExtendedQuickDraw" to mapOf(
                            "Medium" to "U.ExtQ",
                            "Large" to "AR.ExtQ",
                            "SniperRifle" to "S.ExtQ"
                        )
                    ),
                    "Muzzle" to mapOf(
                        "Choke" to "Choke",
                        "Compensator" to mapOf(
                            "Large" to "AR.Comp",
                            "SniperRifle" to "S.Comp"
                        ),
                        "FlashHider" to mapOf(
                            "Large" to "FlashHider",
                            "SniperRifle" to "FlashHider"
                        ),
                        "Suppressor" to mapOf(
                            "Medium" to "U.Supp",
                            "Large" to "AR.Supp",
                            "SniperRifle" to "S.Supp"
                        )
                    ),
                    "Stock" to mapOf(
                        "AR" to "AR.Stock",
                        "SniperRifle" to mapOf(
                            "BulletLoops" to "S.Loops",
                            "CheekPad" to "CheekPad"
                        )
                    ),
                    "Upper" to mapOf(
                        "DotSight" to "R.Dot",
                        "Holosight" to "Holo",
                        "Aimpoint" to "2x",
                        "ACOG" to "4x",
                        "CQBSS" to "8x"
                    )
                )
            ),
            "Boost" to mapOf(
                "EnergyDrink" to "Drink",
                "PainKiller" to "Pain"
            ),
            "Heal" to mapOf(
                "FirstAid" to "FirstAid",
                "MedKit" to "MedKit"
            ),
            "Weapon" to mapOf(
                "HK416" to "m416",
                "M16A4" to "m16",
                "Kar98k" to "98k",
                "SCAR-L" to "Scar",
                "AK47" to "Ak",
                "DP28" to "DP",
                "SKS" to "Sks",
                "Grenade" to "Grenade",
                "Mini14" to "Mini",
                "UMP" to "Ump",
                "Vector" to "Vector",
                "Winchester" to "Win94",
                "Pan" to "Pan"
            ),
            "Ammo" to mapOf(
                "556mm" to "556",
                "762mm" to "762"
            ),
            "Armor" to mapOf(
                "C" to mapOf("01" to mapOf("Lv3" to "armor3")),
                "D" to mapOf("01" to mapOf("Lv2" to "armor2"))
            ),
            "Back" to mapOf(
                "C" to mapOf(
                    "01" to mapOf("Lv3" to "Bag3"),
                    "02" to mapOf("Lv3" to "Bag3")
                ),
                "F" to mapOf(
                    "01" to mapOf("Lv2" to "Bag2"),
                    "02" to mapOf("Lv2" to "Bag2")
                )
            ),
            "Head" to mapOf(
                "F" to mapOf(
                    "01" to mapOf("Lv2" to "Helmet2"),
                    "02" to mapOf("Lv2" to "Helmet2")
                ),
                "G" to mapOf("01" to mapOf("Lv3" to "helmet3"))
            )
        ) as Map<String, Any>

        /**
        * @return null if not good, or short name for it
        */
        fun isGood(description: String): String? {
            try {
                val start = description.indexOf("Item_")
                if (start == -1) return null//not item
                val words = description.substring(start + 5).split("_")
                var c = category
                for (word in words) {
                    if (word !in c) return null
                    val sub = c[word]
                    if (sub is String) return sub
                    c = sub as Map<String, Any>
                }
            } catch (e: Exception) {}
            return null
        }

    }
}
