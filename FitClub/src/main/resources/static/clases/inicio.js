function getWeekRange() {
            const today = new Date();
            // Get current day of the week (0 is Sunday, 6 is Saturday)
            const dayOfWeek = today.getDay();
            // Calculate the difference to get to the previous Monday
            const diffToMonday = dayOfWeek === 0 ? 6 : dayOfWeek - 1;
            // Calculate the Monday of the current week
            const monday = new Date(today);
            monday.setDate(today.getDate() - diffToMonday);
            // Calculate the Saturday of the current week
            const saturday = new Date(monday);
            saturday.setDate(monday.getDate() + 5);

            // Format the dates as dd/mm/yyyy
            const options = { day: '2-digit', month: '2-digit', year: 'numeric' };
            const mondayStr = monday.toLocaleDateString('es-ES', options);
            const saturdayStr = saturday.toLocaleDateString('es-ES', options);

            // Display the dates in the header
            document.getElementById('rangoSemana').innerText = `${mondayStr} - ${saturdayStr}`;
        }