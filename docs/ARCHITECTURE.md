# Architecture Overview

This project (hellogrok) follows **Hexagonal Architecture** (Ports and Adapters) with strict governance using **ArchUnit**.

## Why Hexagonal?

- Protects business logic from technology changes
- Extremely testable
- Suitable for long-lived enterprise systems

Full details about layers and rules are explained in the code structure.

Current implementation demonstrates the complete flow from REST controller → Use Case → Domain → Output Port → Adapter.
