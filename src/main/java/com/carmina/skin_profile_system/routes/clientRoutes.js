import express from "express";
import { protect } from "../middleware/authMiddleware.js";
import { authorizeRoles } from "../middleware/roleMiddleware.js";

const router = express.Router();

// ADMIN + THERAPIST can see all clients
router.get(
  "/",
  protect,
  authorizeRoles("admin", "therapist"),
  (req, res) => {
    res.json({ message: "All clients data" });
  }
);

// CLIENT can ONLY see themselves
router.get(
  "/me",
  protect,
  authorizeRoles("client"),
  (req, res) => {
    res.json({ message: "Your personal client data" });
  }
);

export default router;